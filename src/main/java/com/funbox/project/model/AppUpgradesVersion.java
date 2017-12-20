package com.funbox.project.model;

import javax.persistence.*;

@Table(name = "app_upgrades_version")
public class AppUpgradesVersion {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "app_type")
    private String appType;

    @Column(name = "newest_version")
    private String newestVersion;

    @Column(name = "lowest_version")
    private String lowestVersion;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return app_type
     */
    public String getAppType() {
        return appType;
    }

    /**
     * @param appType
     */
    public void setAppType(String appType) {
        this.appType = appType;
    }

    /**
     * @return newest_version
     */
    public String getNewestVersion() {
        return newestVersion;
    }

    /**
     * @param newestVersion
     */
    public void setNewestVersion(String newestVersion) {
        this.newestVersion = newestVersion;
    }

    /**
     * @return lowest_version
     */
    public String getLowestVersion() {
        return lowestVersion;
    }

    /**
     * @param lowestVersion
     */
    public void setLowestVersion(String lowestVersion) {
        this.lowestVersion = lowestVersion;
    }
}