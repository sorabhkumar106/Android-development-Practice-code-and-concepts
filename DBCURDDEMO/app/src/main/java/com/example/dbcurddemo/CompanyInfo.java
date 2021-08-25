package com.example.dbcurddemo;

public class CompanyInfo {
    private  int serialNo;
    private String companyName;
    private  String companyCeo;
    private  String CompanyIndustry;

    public CompanyInfo() {
    }

    public CompanyInfo( String companyName, String companyCeo, String companyIndustry) {
        this.companyName = companyName;
        this.companyCeo = companyCeo;
        CompanyIndustry = companyIndustry;
    }

    public CompanyInfo(int serialNo, String companyName, String companyCeo, String companyIndustry) {
        this.serialNo = serialNo;
        this.companyName = companyName;
        this.companyCeo = companyCeo;
        CompanyIndustry = companyIndustry;
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "serialNo=" + serialNo +
                ", companyName='" + companyName + '\'' +
                ", companyCeo='" + companyCeo + '\'' +
                ", CompanyIndustry='" + CompanyIndustry + '\'' +
                '}';
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyCeo(String companyCeo) {
        this.companyCeo = companyCeo;
    }

    public void setCompanyIndustry(String companyIndustry) {
        CompanyIndustry = companyIndustry;
    }


    public String getCompanyName() {
        return companyName;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public String getCompanyCeo() {
        return companyCeo;
    }

    public String getCompanyIndustry() {
        return CompanyIndustry;
    }
}
