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
 *  $Id$
 *
 */

package org.ow2.sirocco.cloudmanager.core.exception;

/**
 * The server is currently unable to handle the request 
 * due to temporary overloading or maintenance of the server
 */
public class ServiceUnavailableException extends CloudProviderException {
    private static final long serialVersionUID = 5657353511794738070L;

    /**
     * Constructs a ServiceUnavailableException with null as its error detail
     * message.
     */
    public ServiceUnavailableException() {
    }

    /**
     * Constructs a ServiceUnavailableException with a detail message.
     * 
     * @param message the detail message
     */
    public ServiceUnavailableException(String message) {
        super(message);
    }

}
