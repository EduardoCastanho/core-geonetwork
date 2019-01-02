/*
 * Copyright (C) 2001-2018 Food and Agriculture Organization of the
 * United Nations (FAO-UN), United Nations World Food Programme (WFP)
 * and United Nations Environment Programme (UNEP)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
 *
 * Contact: Jeroen Ticheler - FAO - Viale delle Terme di Caracalla 2,
 * Rome - Italy. email: geonetwork@osgeo.org
 */
package v350;

import org.fao.geonet.DatabaseMigrationTask;
import org.fao.geonet.migration.JsonDatabaseMigration;

import java.util.HashMap;
import java.util.Map;

/**
 * Migration for adding the settings for the logo header position to ui/config setting.
 */
public class LogoPositionInHeaderMigration extends JsonDatabaseMigration {

    private final String settingName = "ui/config";

    @Override
    protected Map<String, String> setUpNewSettingValues() {
        Map<String, String> fieldsToUpdate = new HashMap<>(1);
        fieldsToUpdate.put("/mods/header/isLogoInHeader",
            "true");
        fieldsToUpdate.put("/mods/header/logoInHeaderPosition",
            "\"left\"");


        return fieldsToUpdate;
    }

    @Override
    protected String getSettingName() {
        return settingName;
    }
}
