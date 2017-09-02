package com.yonyou.component.webservice.client;

public class IWebServiceTestProxy implements com.yonyou.component.webservice.client.IWebServiceTest {
  private String _endpoint = null;
  private com.yonyou.component.webservice.client.IWebServiceTest iWebServiceTest = null;
  
  public IWebServiceTestProxy() {
    _initIWebServiceTestProxy();
  }
  
  public IWebServiceTestProxy(String endpoint) {
    _endpoint = endpoint;
    _initIWebServiceTestProxy();
  }
  
  private void _initIWebServiceTestProxy() {
    try {
      iWebServiceTest = (new com.yonyou.component.webservice.client.WebServiceTestImpServiceLocator()).getWebServiceTestImpPort();
      if (iWebServiceTest != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iWebServiceTest)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iWebServiceTest)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iWebServiceTest != null)
      ((javax.xml.rpc.Stub)iWebServiceTest)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.yonyou.component.webservice.client.IWebServiceTest getIWebServiceTest() {
    if (iWebServiceTest == null)
      _initIWebServiceTestProxy();
    return iWebServiceTest;
  }
  
  public com.yonyou.component.webservice.client.UserBean getInfo(java.lang.String arg0) throws java.rmi.RemoteException{
    if (iWebServiceTest == null)
      _initIWebServiceTestProxy();
    return iWebServiceTest.getInfo(arg0);
  }
  
  
}