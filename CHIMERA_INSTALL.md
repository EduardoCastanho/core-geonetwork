1- change data folder
@ (tomcat webapps)/geonetwork/WEB-INF/web.xml

```xml
  <init-param>
      <param-name>geonetwork.dir</param-name>
      <param-value>/srv/geonetwork_data</param-value>
    </init-param>
```
2- DATBASE



3- default language
@ (tomcat webapps)/geonetwork/WEB-INF/config.properties
 
```language.default=por```
