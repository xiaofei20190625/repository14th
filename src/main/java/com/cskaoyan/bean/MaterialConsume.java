package com.cskaoyan.bean;

import java.util.Date;

public class MaterialConsume {
    private Integer consumeAmount;

    private Date consumeDate;

    private String consumeId;

    private Material material = new Material();

    private String note;

    private String receiver;

    private String sender;

    private Work work = new Work();

    public MaterialConsume() {
    }

    public MaterialConsume(Integer consumeAmount, Date consumeDate, String consumeId, Material material, String note, String receiver, String sender, Work work) {
        this.consumeAmount = consumeAmount;
        this.consumeDate = consumeDate;
        this.consumeId = consumeId;
        this.material = material;
        this.note = note;
        this.receiver = receiver;
        this.sender = sender;
        this.work = work;
    }

    public String getConsumeId() {
        return consumeId;
    }

    public void setConsumeId(String consumeId) {
        this.consumeId = consumeId == null ? null : consumeId.trim();
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public String getWorkId(){
        return work.getWorkId();
    }

    public void setWorkId(String workId){
        work.setWorkId(workId);
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setMaterialId(String materialId){
        material.setMaterialId(materialId);
    }

    public String getMaterialId(){
        return material.getMaterialId();
    }

    public Integer getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(Integer consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public Date getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(Date consumeDate) {
        this.consumeDate = consumeDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

}