/**
 *
 * SIROCCO
 * Copyright (C) 2011 France Telecom
 * Contact: sirocco@ow2.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 * USA
 *
 *  $Id: CloudProvider.java 788 2011-12-21 11:49:55Z dangtran $
 *
 */

package org.ow2.sirocco.cloudmanager.model.cimi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * A CloudProvider can provision compute resources (virtual machines along with
 * their network and storage resources). A CloudProvider can represent a private
 * cloud (e.g. an OpenStack instance available within a corporate network) or a
 * public cloud (e.g. Amazon EC2).
 */
@Entity
public class CloudProvider implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String cloudProviderType;

    private String description;

    private List<CloudProviderAccount> cloudProviderAccounts;
    
    private List<CloudProviderLocation> cloudProviderLocations;

    public CloudProvider() {
        this.cloudProviderAccounts = new ArrayList<CloudProviderAccount>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * DUMMY, OPENSTACK_NOVA, ...
     * 
     * @return
     */
    public String getCloudProviderType() {
        return this.cloudProviderType;
    }

    public void setCloudProviderType(final String cloudProviderType) {
        this.cloudProviderType = cloudProviderType;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "cloudProvider", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<CloudProviderAccount> getCloudProviderAccounts() {
        return this.cloudProviderAccounts;
    }

    public void setCloudProviderAccounts(final List<CloudProviderAccount> cloudProviderAccounts) {
        this.cloudProviderAccounts = cloudProviderAccounts;
    }

	@OneToMany
	public List<CloudProviderLocation> getCloudProviderLocations() {
		return cloudProviderLocations;
	}
	
	public void setCloudProviderLocations(
			List<CloudProviderLocation> cloudProviderLocations) {
		this.cloudProviderLocations = cloudProviderLocations;
	}

}