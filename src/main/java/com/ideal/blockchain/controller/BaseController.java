package com.ideal.blockchain.controller;

public  class BaseController {

    protected static String[] addArgsForCollectionName(String colName,String[] args){
        String[] newArgs = new String[args.length+1];
        System.arraycopy(args,0,newArgs,1,args.length);
        newArgs[0] = colName;
        return newArgs;
    }
}
