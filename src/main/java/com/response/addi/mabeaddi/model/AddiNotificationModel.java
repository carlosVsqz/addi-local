package com.response.addi.mabeaddi.model;

import java.io.Serializable;

/**
 * The type Addi notification model.
 */
public class AddiNotificationModel implements Serializable {

    private String orderId;
    private String applicationId;
    private String approvedAmount;
    private String currency;
    private String status;
    private String statusTimestamp;

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Sets order id.
     *
     * @param orderId the order id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets application id.
     *
     * @return the application id
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Sets application id.
     *
     * @param applicationId the application id
     */
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * Gets approved amount.
     *
     * @return the approved amount
     */
    public String getApprovedAmount() {
        return approvedAmount;
    }

    /**
     * Sets approved amount.
     *
     * @param approvedAmount the approved amount
     */
    public void setApprovedAmount(String approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets currency.
     *
     * @param currency the currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets status timestamp.
     *
     * @return the status timestamp
     */
    public String getStatusTimestamp() {
        return statusTimestamp;
    }

    /**
     * Sets status timestamp.
     *
     * @param statusTimestamp the status timestamp
     */
    public void setStatusTimestamp(String statusTimestamp) {
        this.statusTimestamp = statusTimestamp;
    }

    @Override
    public String toString() {
        return "AddiNotificationModel{" +
                "orderId='" + orderId + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", approvedAmount='" + approvedAmount + '\'' +
                ", currency='" + currency + '\'' +
                ", status='" + status + '\'' +
                ", statusTimestamp='" + statusTimestamp + '\'' +
                '}';
    }
}
