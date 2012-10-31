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

package org.ow2.sirocco.apis.rest.cimi.tools;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.nocrala.tools.texttablefmt.Table;
import org.ow2.sirocco.cloudmanager.core.api.ICloudProviderManager;
import org.ow2.sirocco.cloudmanager.core.api.IRemoteCloudProviderManager;
import org.ow2.sirocco.cloudmanager.model.cimi.extension.CloudProvider;
import org.ow2.sirocco.cloudmanager.model.cimi.extension.CloudProviderLocation;

import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "list cloud providers")
public class CloudProviderListCommand implements Command {
    public static String COMMAND_NAME = "cloud-provider-list";

    @Override
    public String getName() {
        return CloudProviderListCommand.COMMAND_NAME;
    }

    @Override
    public void execute() throws Exception {
        Context context = new InitialContext();
        IRemoteCloudProviderManager cloudProviderManager = (IRemoteCloudProviderManager) context
            .lookup(ICloudProviderManager.EJB_JNDI_NAME);

        List<CloudProvider> providers = cloudProviderManager.getCloudProviders();

        Table table = new Table(5);
        table.addCell("Cloud Provider ID");
        table.addCell("Type");
        table.addCell("Endpoint");
        table.addCell("Description");
        table.addCell("Locations");

        for (CloudProvider provider : providers) {
            table.addCell(provider.getId().toString());
            table.addCell(provider.getCloudProviderType());
            table.addCell(provider.getEndpoint());
            table.addCell(provider.getDescription());
            StringBuffer sb = new StringBuffer();
            for (CloudProviderLocation loc : provider.getCloudProviderLocations()) {
                sb.append(loc.getCountryName() + " ");
            }
            table.addCell(sb.toString());
        }

        System.out.println(table.render());
    }
}