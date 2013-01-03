package org.fao.geonet.services.region;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

import jeeves.server.context.ServiceContext;

import org.fao.geonet.GeonetContext;
import org.fao.geonet.constants.Geonet;
import org.fao.geonet.kernel.Thesaurus;
import org.fao.geonet.kernel.ThesaurusManager;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;

public class ThesaurusBasedRegionsDAO extends RegionsDAO {
    
    private final Set<String> localesToLoad;
    private WeakHashMap<String, Map<String, String>> categoryIdMap = new WeakHashMap<String, Map<String, String>>();
    private GeometryFactory factory = new GeometryFactory();
    private String thesaurusName = "external.place.regions";
    public ThesaurusBasedRegionsDAO(java.util.Set<String> localesToLoad) {
        this.localesToLoad = Collections.unmodifiableSet(localesToLoad);
    }
    
    @Override
    public Request createSearchRequest(ServiceContext context) throws Exception {
        Thesaurus thesaurus = getThesaurus(context);

        return new ThesaurusRequest(context, this.categoryIdMap , localesToLoad, thesaurus);
    }
    
    public synchronized void setThesaurusName(String thesaurusName) {
        super.clearCaches();
        this.thesaurusName = thesaurusName;
    }

    private Thesaurus getThesaurus(ServiceContext context) throws Exception {
        GeonetContext gc = (GeonetContext) context.getHandlerContext(Geonet.CONTEXT_NAME);
        ThesaurusManager th = gc.getThesaurusManager();
        Thesaurus regions = th.getThesaurusByName(thesaurusName);
        if(regions != null) {
            return regions;
        }
        Set<Entry<String, Thesaurus>> all = th.getThesauriMap().entrySet();
        for (Entry<String, Thesaurus> entry : all) {
            if(entry.getKey().contains("regions")) {
                return entry.getValue();
            }
        }
        
        return null;
    }

    @Override
    public Geometry getGeom(ServiceContext context, String id, boolean simplified, CoordinateReferenceSystem projection) throws Exception {
        Region region = createSearchRequest(context).id(id).get();
        if(region == null) {
            return null;
        }
       
        Geometry geometry = factory.toGeometry(region.getBBox(projection));
        geometry.setUserData(region.getBBox().getCoordinateReferenceSystem());
        
        return geometry;
    }

	@Override
	public Collection<String> getRegionCategoryIds(ServiceContext context) {
		
		return null;
	}

}
