DELETE FROM Settings WHERE  name = 'metadata/editor/schemaConfig';

UPDATE Settings set value = '{"langDetector":{"fromHtmlTag":false,"regexp":"^/[a-zA-Z0-9_-]+/[a-zA-Z0-9_-]+/([a-z]{3})/","default":"eng"},"nodeDetector":{"regexp":"^/[a-zA-Z0-9_-]+/([a-zA-Z0-9_-]+)/[a-z]{3}/","default":"srv"},"mods":{"header":{"enabled":true,"languages":{"eng":"en","dut":"nl","fre":"fr","ger":"de","kor":"ko","spa":"es","cze":"cs","cat":"ca","fin":"fi","ice":"is", "rus": "ru", "chi": "zh"}},"home":{"enabled":true,"appUrl":"../../srv/{{lang}}/catalog.search#/home"},"search":{"enabled":true,"appUrl":"../../srv/{{lang}}/catalog.search#/search","hitsperpageValues":[10,50,100],"paginationInfo":{"hitsPerPage":20},"facetsSummaryType":"details","facetConfig":[],"facetTabField":"","filters":{},"sortbyValues":[{"sortBy":"relevance","sortOrder":""},{"sortBy":"changeDate","sortOrder":""},{"sortBy":"title","sortOrder":"reverse"},{"sortBy":"rating","sortOrder":""},{"sortBy":"popularity","sortOrder":""},{"sortBy":"denominatorDesc","sortOrder":""},{"sortBy":"denominatorAsc","sortOrder":"reverse"}],"sortBy":"relevance","resultViewTpls":[{"tplUrl":"../../catalog/components/search/resultsview/partials/viewtemplates/grid.html","tooltip":"Grid","icon":"fa-th"}],"resultTemplate":"../../catalog/components/search/resultsview/partials/viewtemplates/grid.html","formatter":{"list":[{"label":"full","url":"../api/records/{{uuid}}/formatters/xsl-view?root=div&view=advanced"}]},"grid":{"related":["parent","children","services","datasets"]},"linkTypes":{"links":["LINK","kml"],"downloads":["DOWNLOAD"],"layers":["OGC"],"maps":["ows"]},"isFilterTagsDisplayedInSearch":false},"map":{"enabled":true,"appUrl":"../../srv/{{lang}}/catalog.search#/map","is3DModeAllowed":true,"isSaveMapInCatalogAllowed":true,"isExportMapAsImageEnabled":true,"bingKey":"AnElW2Zqi4fI-9cYx1LHiQfokQ9GrNzcjOh_p_0hkO1yo78ba8zTLARcLBIf8H6D","storage":"sessionStorage","map":"../../map/config-viewer.xml","listOfServices":{"wms":[],"wmts":[]},"useOSM":true,"context":"","layer":{"url":"http://www2.demis.nl/mapserver/wms.asp?","layers":"Countries","version":"1.1.1"},"projection":"EPSG:3857","projectionList":[{"code":"EPSG:4326","label":"WGS84(EPSG:4326)"},{"code":"EPSG:3857","label":"Googlemercator(EPSG:3857)"}],"disabledTools":{"processes":false,"addLayers":false,"layers":false,"filter":false,"contexts":false,"print":false,"mInteraction":false,"graticule":false,"syncAllLayers":false,"drawVector":false},"searchMapLayers":[],"viewerMapLayers":[]},"editor":{"enabled":true,"appUrl":"../../srv/{{lang}}/catalog.edit","isUserRecordsOnly":false,"isFilterTagsDisplayed":false,"createPageTpl": "../../catalog/templates/editor/new-metadata-horizontal.html"},"admin":{"enabled":true,"appUrl":"../../srv/{{lang}}/admin.console"},"signin":{"enabled":true,"appUrl":"../../srv/{{lang}}/catalog.signin"},"signout":{"appUrl":"../../signout"}}}', datatype = 3, position = 10000, internal = 'n' where name like 'ui/config';


INSERT INTO Settings (name, value, datatype, position, internal) VALUES ('system/metadata/validation/removeSchemaLocation', 'false', 2, 9170, 'n');

UPDATE Settings SET value='3.4.0' WHERE name='system/platform/version';
UPDATE Settings SET value='SNAPSHOT' WHERE name='system/platform/subVersion';
