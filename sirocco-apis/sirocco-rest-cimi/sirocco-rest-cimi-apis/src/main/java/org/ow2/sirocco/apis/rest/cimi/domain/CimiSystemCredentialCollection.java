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
 * Collection of SystemCredential.
 */
@XmlRootElement(name = "Collection")
@JsonSerialize(include = Inclusion.NON_NULL)
public class CimiSystemCredentialCollection extends CimiCollectionAbstract<CimiSystemCredential> {

    /** Serial number */
    private static final long serialVersionUID = 1L;

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.apis.rest.cimi.domain.CimiCollectionAbstract#getArray()
     */
    @Override
    @XmlElement(name = "SystemCredential")
    @JsonProperty(value = "systemCredentials")
    public CimiSystemCredential[] getArray() {
        return super.getArray();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.apis.rest.cimi.domain.CimiCollectionAbstract#setArray(E[])
     */
    @Override
    @JsonProperty(value = "systemCredentials")
    public void setArray(final CimiSystemCredential[] items) {
        super.setArray(items);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.apis.rest.cimi.domain.CimiCollection#newCollection()
     */
    @Override
    public CimiArray<CimiSystemCredential> newCollection() {
        return new CimiSystemCredentialArray();
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
        return ExchangeType.SystemCredentialCollection;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.ow2.sirocco.apis.rest.cimi.domain.CimiCollection#getItemClass()
     */
    @Override
    @XmlTransient
    @JsonIgnore
    public Class<CimiSystemCredential> getItemClass() {
        return CimiSystemCredential.class;
    }

    /**
     * Concrete class of the collection.
     */
    public class CimiSystemCredentialArray extends CimiArrayAbstract<CimiSystemCredential> {

        /** Serial number */
        private static final long serialVersionUID = 1L;

        @Override
        public CimiSystemCredential[] newEmptyArraySized() {
            return new CimiSystemCredential[this.size()];
        }
    }
}
