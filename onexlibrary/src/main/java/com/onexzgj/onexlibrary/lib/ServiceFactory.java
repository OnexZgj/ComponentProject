package com.onexzgj.onexlibrary.lib;

/**
 * des：服务提供者
 * author：onexzgj
 * time：2019/3/24
 */
public class ServiceFactory {
    private static final ServiceFactory ourInstance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return ourInstance;
    }


    private IloginService iloginService;

    private ServiceFactory() {

    }

    public IloginService getIloginService() {
        if (iloginService==null){
            iloginService=new EmptyLoginService();
        }
        return iloginService;
    }

    public void setIloginService(IloginService iloginService) {
        this.iloginService = iloginService;
    }
}
