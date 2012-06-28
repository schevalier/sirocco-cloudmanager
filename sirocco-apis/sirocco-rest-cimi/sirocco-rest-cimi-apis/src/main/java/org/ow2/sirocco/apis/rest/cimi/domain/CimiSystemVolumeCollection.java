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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 *
 * $Id$
 *
 */
package org.ow2.sirocco.apis.rest.cimi.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

/**
 * Collection of SystemVolume.
 */
@XmlRootElement(name = "Collection")
@JsonSerialize(include = Inclusion.NON_NULL)
public class CimiSystemVolumeCollection extends CimiCollectionAbstract<CimiSystemVolume> {

    /** Serial number */
    private static final long serialVersionUID = 1L;

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.apis.rest.cimi.domain.CimiCollectionAbstract#getArray()
     */
    @Override
    @XmlElement(name = "SystemVolume")
    @JsonProperty(value = "systemVolumes")
    public CimiSystemVolume[] getArray() {
        return super.getArray();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.apis.rest.cimi.domain.CimiCollectionAbstract#setArray(E[])
     */
    @Override
    @JsonProperty(value = "systemVolumes")
    public void setArray(final CimiSystemVolume[] items) {
        super.setArray(items);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.apis.rest.cimi.domain.CimiCollection#newCollection()
     */
    @Override
    public CimiArray<CimiSystemVolume> newCollection() {
        return new CimiSystemVolumeArray();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.apis.rest.cimi.domain.CimiExchange#getExchangeType()
     */
    @Override
    @XmlTransient
    @JsonIgnore
    public ExchangeType getExchangeType() {
        return ExchangeType.SystemVolumeCollection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.apis.rest.cimi.domain.CimiCollection#getItemClass()
     */
    @Override
    @XmlTransient
    @JsonIgnore
    public Class<CimiSystemVolume> getItemClass() {
        return CimiSystemVolume.class;
    }

    /**
     * Concrete class of the collection.
     */
    public class CimiSystemVolumeArray extends CimiArrayAbstract<CimiSystemVolume> {

        /** Serial number */
        private static final long serialVersionUID = 1L;

        @Override
        public CimiSystemVolume[] newEmptyArraySized() {
            return new CimiSystemVolume[this.size()];
        }
    }
}
