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
 * $Id: java 1096 2012-03-09 08:08:25Z antonma $
 *
 */
package org.ow2.sirocco.apis.rest.cimi.resource.serialization;

import java.io.StringReader;

import junit.framework.Assert;
import net.javacrumbs.jsonunit.JsonAssert;

import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.ow2.sirocco.apis.rest.cimi.resource.serialization.json.JsonLocator;
import org.ow2.sirocco.apis.rest.cimi.resource.serialization.xml.XmlLocator;
import org.ow2.sirocco.apis.rest.cimi.server.SiroccoRestCimiApplication;
import org.ow2.sirocco.apis.rest.cimi.utils.Constants;
import org.ow2.sirocco.apis.rest.cimi.utils.ConstantsPath;
import org.ow2.sirocco.apis.rest.cimi.utils.MediaTypeCimi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;

public class SerializationMachineImageResourceTest extends JerseyTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(SerializationMachineImageResourceTest.class);

    /**
     * {@inheritDoc}
     * 
     * @see com.sun.jersey.test.framework.JerseyTest#configure()
     */
    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder("javax.ws.rs.Application", SiroccoRestCimiApplication.class.getName())
            .initParam(JSONConfiguration.FEATURE_POJO_MAPPING, "true").contextPath("sirocco-rest")
            .servletClass(SpringServlet.class).contextListenerClass(ContextLoaderListener.class)
            .contextParam("contextConfigLocation", "classpath:context/serializationResourcesContext.xml").build();
    }

    /**
     * @throws Exception In case of error
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        XMLUnit.setIgnoreWhitespace(true);
        XMLUnit.setIgnoreComments(true);
    }

    /**
     * Test GET.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testGetMachineImageJson() throws Exception {
        ClientResponse clientResponse = null;
        String entityResponse;
        int statusResponse;

        // JSON : id = 0
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE + "/0")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI).get(ClientResponse.class);
        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(SerializationHelper.getResourceAsReader(JsonLocator.class, "MachineImage-0.json"),
            new StringReader(entityResponse));

        // JSON : id = 1
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE + "/1")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI).get(ClientResponse.class);
        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(SerializationHelper.getResourceAsReader(JsonLocator.class, "MachineImage-1.json"),
            new StringReader(entityResponse));

        // JSON : id = 2
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE + "/2")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI).get(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(SerializationHelper.getResourceAsReader(JsonLocator.class, "MachineImage-2.json"),
            new StringReader(entityResponse));
    }

    /**
     * Test GET.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testGetMachineImageXml() throws Exception {
        ClientResponse clientResponse = null;
        String entityResponse;
        int statusResponse;

        // XML : id = 0
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE + "/0")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI).get(ClientResponse.class);
        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "MachineImage-0.xml"),
            new StringReader(entityResponse));

        // XML : id = 1
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE + "/1")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI).get(ClientResponse.class);
        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "MachineImage-1.xml"),
            new StringReader(entityResponse));

        // XML : id = 2
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE + "/2")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI).get(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "MachineImage-2.xml"),
            new StringReader(entityResponse));
    }

    /**
     * Test GET.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testGetMachineImageCollectionJson() throws Exception {
        ClientResponse clientResponse = null;
        String entityResponse;
        int statusResponse;

        // JSON : id = 0
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE)
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 0).get(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(
            SerializationHelper.getResourceAsReader(JsonLocator.class, "MachineImageCollection-0.json"), new StringReader(
                entityResponse));

        // JSON : id = 1
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE)
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 1).get(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(
            SerializationHelper.getResourceAsReader(JsonLocator.class, "MachineImageCollection-1.json"), new StringReader(
                entityResponse));

        // JSON : id = 3
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE)
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 3).get(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(
            SerializationHelper.getResourceAsReader(JsonLocator.class, "MachineImageCollection-3.json"), new StringReader(
                entityResponse));

        // JSON : id = 3, expand
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE)
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 3).header(Constants.HEADER_SIROCCO_INFO_TEST_EXPAND, true)
            .get(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(
            SerializationHelper.getResourceAsReader(JsonLocator.class, "MachineImageCollection-3-expand.json"),
            new StringReader(entityResponse));
    }

    /**
     * Test GET.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testGetMachineImageCollectionXml() throws Exception {
        ClientResponse clientResponse = null;
        String entityResponse;
        int statusResponse;

        // XML : id = 0
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE)
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 0).get(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "MachineImageCollection-0.xml"),
            new StringReader(entityResponse));

        // XML : id = 1
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE)
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 1).get(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "MachineImageCollection-1.xml"),
            new StringReader(entityResponse));

        // XML : id = 3
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE)
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 3).get(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "MachineImageCollection-3.xml"),
            new StringReader(entityResponse));

        // XML : id = 3, expand
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE)
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .header(Constants.HEADER_SIROCCO_INFO_TEST_ID, 3).header(Constants.HEADER_SIROCCO_INFO_TEST_EXPAND, true)
            .get(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class,
            "MachineImageCollection-3-expand.xml"), new StringReader(entityResponse));
    }

    /**
     * Test PUT.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testPutMachineImageJson() throws Exception {
        ClientResponse clientResponse = null;
        String entityResponse;
        int statusResponse;

        // JSON : id = 0
        clientResponse = this
            .resource()
            .path(ConstantsPath.MACHINE_IMAGE + "/0")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .entity(SerializationHelper.getResourceAsString(JsonLocator.class, "MachineImage-0.json"),
                MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_JSON).put(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(SerializationHelper.getResourceAsReader(JsonLocator.class, "Job-0.json"), new StringReader(
            entityResponse));

        // JSON : id = 1
        clientResponse = this
            .resource()
            .path(ConstantsPath.MACHINE_IMAGE + "/1")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .entity(SerializationHelper.getResourceAsString(JsonLocator.class, "MachineImage-1.json"),
                MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_JSON).put(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(SerializationHelper.getResourceAsReader(JsonLocator.class, "Job-1.json"), new StringReader(
            entityResponse));

        // JSON : id = 2
        clientResponse = this
            .resource()
            .path(ConstantsPath.MACHINE_IMAGE + "/2")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .entity(SerializationHelper.getResourceAsString(JsonLocator.class, "MachineImage-2.json"),
                MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_JSON).put(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        JsonAssert.assertJsonEquals(SerializationHelper.getResourceAsReader(JsonLocator.class, "Job-2.json"), new StringReader(
            entityResponse));

    }

    /**
     * Test PUT.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testPutMachineImageJsonMalformed() throws Exception {
        ClientResponse clientResponse = null;
        String entityResponse;
        int statusResponse;

        // JSON : id = 0
        clientResponse = this
            .resource()
            .path(ConstantsPath.MACHINE_IMAGE + "/0")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .entity(SerializationHelper.getResourceAsString(JsonLocator.class, "MachineImage-0_malformed.json"),
                MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_JSON).put(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(500, statusResponse);
    }

    /**
     * Test PUT.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testPutMachineImageXml() throws Exception {
        ClientResponse clientResponse = null;
        String entityResponse;
        int statusResponse;

        // XML : id = 0
        clientResponse = this
            .resource()
            .path(ConstantsPath.MACHINE_IMAGE + "/0")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .entity(SerializationHelper.getResourceAsString(XmlLocator.class, "MachineImage-0.xml"),
                MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_XML).put(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "Job-0.xml"), new StringReader(
            entityResponse));

        // XML : id = 1
        clientResponse = this
            .resource()
            .path(ConstantsPath.MACHINE_IMAGE + "/1")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .entity(SerializationHelper.getResourceAsString(XmlLocator.class, "MachineImage-1.xml"),
                MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_XML).put(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "Job-1.xml"), new StringReader(
            entityResponse));

        // XML : id = 2
        clientResponse = this
            .resource()
            .path(ConstantsPath.MACHINE_IMAGE + "/2")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .entity(SerializationHelper.getResourceAsString(XmlLocator.class, "MachineImage-2.xml"),
                MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_XML).put(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(200, statusResponse);
        XMLAssert.assertXMLEqual(SerializationHelper.getResourceAsReader(XmlLocator.class, "Job-2.xml"), new StringReader(
            entityResponse));

    }

    /**
     * Test PUT.
     * 
     * @throws Exception In case of error
     */
    @Test
    public final void testPutMachineImageXmlMalformed() throws Exception {
        ClientResponse clientResponse = null;
        String entityResponse;
        int statusResponse;

        // XML : id = 0
        clientResponse = this
            .resource()
            .path(ConstantsPath.MACHINE_IMAGE + "/0")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECOLLECTION_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .entity(SerializationHelper.getResourceAsString(XmlLocator.class, "MachineImage-0_malformed.xml"),
                MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_XML).put(ClientResponse.class);

        statusResponse = clientResponse.getStatus();
        entityResponse = clientResponse.getEntity(String.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", statusResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", entityResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        Assert.assertEquals(400, statusResponse);
    }

    @Test
    @Ignore
    public final void testPostMachineImage() {
        ClientResponse clientResponse = null;
        String json;

        // JSON : ok
        SerializationMachineImageResourceTest.LOGGER.debug("\n===== POST : {}", "JSON : ok");
        json = "{\"name\":\"nameValue\",\"description\":\"descriptionValue\",\"imageLocation\":\"imageLocationValue\"}";
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE).accept(MediaTypeCimi.APPLICATION_CIMI_JOB_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .entity(json, MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECREATE_JSON).post(ClientResponse.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", clientResponse.getStatus());
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", clientResponse.getEntity(String.class));
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        String xml;
        // XML : ok
        SerializationMachineImageResourceTest.LOGGER.debug("\n===== POST : {}", "XML : ok");

        xml = "<machineImage><name>nameValue</name><description>descriptionValue</description><imageLocation>imageLocationValue</imageLocation></machineImage>";
        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE).accept(MediaTypeCimi.APPLICATION_CIMI_JOB_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI)
            .entity(xml, MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGECREATE_XML).post(ClientResponse.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", clientResponse.getStatus());
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", clientResponse.getEntity(String.class));
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());
    }

    @Test
    @Ignore
    public final void testDeleteMachineImage() {
        ClientResponse clientResponse = null;

        // JSON
        SerializationMachineImageResourceTest.LOGGER.debug("\n===== DELETE: {}", "JSON");

        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE + "/834752")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_JSON_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI).delete(ClientResponse.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", clientResponse.getStatus());
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", clientResponse.getEntity(String.class));
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());

        // XML
        SerializationMachineImageResourceTest.LOGGER.debug("\n===== DELETE: {}", "XML");

        clientResponse = this.resource().path(ConstantsPath.MACHINE_IMAGE + "/834752")
            .accept(MediaTypeCimi.APPLICATION_CIMI_MACHINEIMAGE_XML_TYPE)
            .header(Constants.HEADER_CIMI_VERSION, Constants.VERSION_DMTF_CIMI).delete(ClientResponse.class);

        SerializationMachineImageResourceTest.LOGGER.debug("COMPLETE:\n\t{}", clientResponse);
        SerializationMachineImageResourceTest.LOGGER.debug("STATUS: {}", clientResponse.getStatus());
        SerializationMachineImageResourceTest.LOGGER.debug("ENTITY:\n\t{}", clientResponse.getEntity(String.class));
        SerializationMachineImageResourceTest.LOGGER.debug("HEADER:\n\t{}", clientResponse.getHeaders());
    }
}
