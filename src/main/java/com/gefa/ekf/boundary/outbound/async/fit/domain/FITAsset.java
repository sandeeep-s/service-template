package com.gefa.ekf.boundary.outbound.async.fit.domain;

import java.math.BigDecimal;
import java.util.Date;

public class FITAsset extends AbstractTransferObject {

	protected String userKz;
	protected Long sessionId;
	protected Long partnerId;
	protected Long businessTypeRc;
	protected String serialNo;
	protected Long manufacturerRc;
	protected String assetName;
	protected String internalRefNo;
	protected Integer constructionYear;
	protected Date invoiceDate;
	protected String invoiceNumber;
	protected String invoiceFileFormat;
	protected byte[] invoiceFile;
	protected Date disbursementDate;
	protected BigDecimal netPrice;
	protected Long assetTypeRc;
	protected String disbursementFlag;
	protected Boolean paymentProofAvailable;
	protected String paymentProofFileFormat;
	protected byte[] paymentProofFile;
	protected Boolean regDocAvailable;
	protected String regDocFileFormat;
	protected byte[] regDocFile;
	protected Date deregistrationDate;
	protected String dealerComments;
	protected Long vendorId;
	protected String objCatalogId;
	protected String initiatingUser;
	protected Long durationInMonths;

	public String getUserKz() {
		return userKz;
	}

	public void setUserKz(String userKz) {
		this.userKz = userKz;
	}

	public Long getSessionId() {
		return sessionId;
	}

	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public Long getBusinessTypeRc() {
		return businessTypeRc;
	}

	public void setBusinessTypeRc(Long businessTypeRc) {
		this.businessTypeRc = businessTypeRc;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public Long getManufacturerRc() {
		return manufacturerRc;
	}

	public void setManufacturerRc(Long manufacturerRc) {
		this.manufacturerRc = manufacturerRc;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getInternalRefNo() {
		return internalRefNo;
	}

	public void setInternalRefNo(String internalRefNo) {
		this.internalRefNo = internalRefNo;
	}

	public Integer getConstructionYear() {
		return constructionYear;
	}

	public void setConstructionYear(Integer constructionYear) {
		this.constructionYear = constructionYear;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getInvoiceFileFormat() {
		return invoiceFileFormat;
	}

	public void setInvoiceFileFormat(String invoiceFileFormat) {
		this.invoiceFileFormat = invoiceFileFormat;
	}

	public byte[] getInvoiceFile() {
		return invoiceFile;
	}

	public void setInvoiceFile(byte[] invoiceFile) {
		this.invoiceFile = invoiceFile;
	}

	public Date getDisbursementDate() {
		return disbursementDate;
	}

	public void setDisbursementDate(Date disbursementDate) {
		this.disbursementDate = disbursementDate;
	}

	public BigDecimal getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(BigDecimal netPrice) {
		this.netPrice = netPrice;
	}

	public Long getAssetTypeRc() {
		return assetTypeRc;
	}

	public void setAssetTypeRc(Long assetTypeRc) {
		this.assetTypeRc = assetTypeRc;
	}

	public String getDisbursementFlag() {
		return disbursementFlag;
	}

	public void setDisbursementFlag(String disbursementFlag) {
		this.disbursementFlag = disbursementFlag;
	}

	public Boolean getPaymentProofAvailable() {
		return paymentProofAvailable;
	}

	public void setPaymentProofAvailable(Boolean paymentProofAvailable) {
		this.paymentProofAvailable = paymentProofAvailable;
	}

	public String getPaymentProofFileFormat() {
		return paymentProofFileFormat;
	}

	public void setPaymentProofFileFormat(String paymentProofFileFormat) {
		this.paymentProofFileFormat = paymentProofFileFormat;
	}

	public byte[] getPaymentProofFile() {
		return paymentProofFile;
	}

	public void setPaymentProofFile(byte[] paymentProofFile) {
		this.paymentProofFile = paymentProofFile;
	}

	public Boolean getRegDocAvailable() {
		return regDocAvailable;
	}

	public void setRegDocAvailable(Boolean regDocAvailable) {
		this.regDocAvailable = regDocAvailable;
	}

	public String getRegDocFileFormat() {
		return regDocFileFormat;
	}

	public void setRegDocFileFormat(String regDocFileFormat) {
		this.regDocFileFormat = regDocFileFormat;
	}

	public byte[] getRegDocFile() {
		return regDocFile;
	}

	public void setRegDocFile(byte[] regDocFile) {
		this.regDocFile = regDocFile;
	}

	public Date getDeregistrationDate() {
		return deregistrationDate;
	}

	public void setDeregistrationDate(Date deregistrationDate) {
		this.deregistrationDate = deregistrationDate;
	}

	public String getDealerComments() {
		return dealerComments;
	}

	public void setDealerComments(String dealerComments) {
		this.dealerComments = dealerComments;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getObjCatalogId() {
		return objCatalogId;
	}

	public void setObjCatalogId(String objCatalogId) {
		this.objCatalogId = objCatalogId;
	}

	public String getInitiatingUser() {
		return initiatingUser;
	}

	public void setInitiatingUser(String initiatingUser) {
		this.initiatingUser = initiatingUser;
	}

	public Long getDurationInMonths() {
		return durationInMonths;
	}

	public void setDurationInMonths(Long durationInMonths) {
		this.durationInMonths = durationInMonths;
	}

}