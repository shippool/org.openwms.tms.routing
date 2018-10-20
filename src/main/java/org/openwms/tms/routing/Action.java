/*
 * openwms.org, the Open Warehouse Management System.
 * Copyright (C) 2014 Heiko Scherrer
 *
 * This file is part of openwms.org.
 *
 * openwms.org is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as 
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * openwms.org is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this software. If not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.openwms.tms.routing;

import org.ameba.integration.jpa.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A Action.
 *
 * @author <a href="mailto:scherrer@openwms.org">Heiko Scherrer</a>
 */
@Entity
@Table(name = "RSRV_ACTION")
public class Action extends BaseEntity implements Serializable {

    public Action() {
    }

    public Action(Route route, String name, String locationKey, String locationGroupName, String actionType, String programKey, String description) {
        this.route = route;
        this.name = name;
        this.locationKey = locationKey;
        this.locationGroupName = locationGroupName;
        this.actionType = actionType;
        this.programKey = programKey;
        this.description = description;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "C_ROUTE_ID")
    private Route route;
    @NotNull
    @Column(name = "C_PROGRAM_NAME")
    private String programKey;
    @NotNull
    @Column(name = "C_NAME")
    private String name;
    @Column(name = "C_LOCATION_KEY")
    private String locationKey;
    @Column(name = "C_LOCATION_GROUP_NAME")
    private String locationGroupName;
    @NotNull
    @Column(name = "C_ACTION_TYPE")
    private String actionType;
    @NotNull
    @Column(name = "C_DESCRIPTION")
    private String description;
    @Column(name = "C_ENABLED")
    private boolean enabled = true;

    public Route getRoute() {
        return route;
    }

    public String getProgramKey() {
        return programKey;
    }

    public String getName() {
        return name;
    }

    public String getLocationKey() {
        return locationKey;
    }

    public String getLocationGroupName() {
        return locationGroupName;
    }

    public String getActionType() {
        return actionType;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Action{" +
                "route=" + route +
                ", programKey='" + programKey + '\'' +
                ", name='" + name + '\'' +
                ", locationKey='" + locationKey + '\'' +
                ", locationGroupName='" + locationGroupName + '\'' +
                ", actionType='" + actionType + '\'' +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }
}
