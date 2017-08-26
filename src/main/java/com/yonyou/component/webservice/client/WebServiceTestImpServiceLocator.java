/**
 * WebServiceTestImpServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.yonyou.component.webservice.client;

public class WebServiceTestImpServiceLocator extends org.apache.axis.client.Service implements com.yonyou.component.webservice.client.WebServiceTestImpService {

    public WebServiceTestImpServiceLocator() {
    }


    public WebServiceTestImpServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WebServiceTestImpServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WebServiceTestImpPort
    private java.lang.String WebServiceTestImpPort_address = "http://10.187.47.22:8080/SSM/ws/webservice";

    public java.lang.String getWebServiceTestImpPortAddress() {
        return WebServiceTestImpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebServiceTestImpPortWSDDServiceName = "WebServiceTestImpPort";

    public java.lang.String getWebServiceTestImpPortWSDDServiceName() {
        return WebServiceTestImpPortWSDDServiceName;
    }

    public void setWebServiceTestImpPortWSDDServiceName(java.lang.String name) {
        WebServiceTestImpPortWSDDServiceName = name;
    }

    public com.yonyou.component.webservice.client.IWebServiceTest getWebServiceTestImpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebServiceTestImpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebServiceTestImpPort(endpoint);
    }

    public com.yonyou.component.webservice.client.IWebServiceTest getWebServiceTestImpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.yonyou.component.webservice.client.WebServiceTestImpServiceSoapBindingStub _stub = new com.yonyou.component.webservice.client.WebServiceTestImpServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getWebServiceTestImpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebServiceTestImpPortEndpointAddress(java.lang.String address) {
        WebServiceTestImpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.yonyou.component.webservice.client.IWebServiceTest.class.isAssignableFrom(serviceEndpointInterface)) {
                com.yonyou.component.webservice.client.WebServiceTestImpServiceSoapBindingStub _stub = new com.yonyou.component.webservice.client.WebServiceTestImpServiceSoapBindingStub(new java.net.URL(WebServiceTestImpPort_address), this);
                _stub.setPortName(getWebServiceTestImpPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WebServiceTestImpPort".equals(inputPortName)) {
            return getWebServiceTestImpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.webservice.component.yonyou.com/", "WebServiceTestImpService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.webservice.component.yonyou.com/", "WebServiceTestImpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WebServiceTestImpPort".equals(portName)) {
            setWebServiceTestImpPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
