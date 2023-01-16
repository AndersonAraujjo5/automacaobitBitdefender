package com.pontodata.relatorios.Models;

public class IncidentesRedeModel {
    private String endPoint;
    private String endPointIp;

    private String fqdn;
    private String label;
    private String user;
    private String url;
    private String detectionName;
    private String attackTechnique;
    private String attempts;
    private String attackerIp;
    private String targetIp;
    private String port;
    private String lastBlocked;
    private int count;

    public IncidentesRedeModel(String endPoint, String endPointIp, String fqdn, String label, String user, String url, String detectionName, String attackTechnique, String attempts, String attackerIp, String targetIp, String port, String lastBlocked) {
        this.endPoint = endPoint;
        this.endPointIp = endPointIp;
        this.fqdn = fqdn;
        this.label = label;
        this.user = user;
        this.url = url;
        this.detectionName = detectionName;
        this.attackTechnique = attackTechnique;
        this.attempts = attempts;
        this.attackerIp = attackerIp;
        this.targetIp = targetIp;
        this.port = port;
        this.lastBlocked = lastBlocked;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getEndPointIp() {
        return endPointIp;
    }

    public void setEndPointIp(String endPointIp) {
        this.endPointIp = endPointIp;
    }

    public String getFqdn() {
        return fqdn;
    }

    public void setFqdn(String fqdn) {
        this.fqdn = fqdn;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDetectionName() {
        return detectionName;
    }

    public void setDetectionName(String detectionName) {
        this.detectionName = detectionName;
    }

    public String getAttackTechnique() {
        return attackTechnique;
    }

    public void setAttackTechnique(String attackTechnique) {
        this.attackTechnique = attackTechnique;
    }

    public String getAttempts() {
        return attempts;
    }

    public void setAttempts(String attempts) {
        this.attempts = attempts;
    }

    public String getAttackerIp() {
        return attackerIp;
    }

    public void setAttackerIp(String attackerIp) {
        this.attackerIp = attackerIp;
    }

    public String getTargetIp() {
        return targetIp;
    }

    public void setTargetIp(String targetIp) {
        this.targetIp = targetIp;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getLastBlocked() {
        return lastBlocked;
    }

    public void setLastBlocked(String lastBlocked) {
        this.lastBlocked = lastBlocked;
    }

    public int getCount() {
        return count;
    }

    public void setCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return "IncidentesRedeModel{" +
                "endPoint='" + endPoint + '\'' +
                ", endPointIp='" + endPointIp + '\'' +
                ", fqdn='" + fqdn + '\'' +
                ", label='" + label + '\'' +
                ", user='" + user + '\'' +
                ", url='" + url + '\'' +
                ", detectionName='" + detectionName + '\'' +
                ", attackTechnique='" + attackTechnique + '\'' +
                ", attempts='" + attempts + '\'' +
                ", attackerIp='" + attackerIp + '\'' +
                ", targetIp='" + targetIp + '\'' +
                ", port='" + port + '\'' +
                ", lastBlocked='" + lastBlocked + '\'' +
                '}';
    }
}
