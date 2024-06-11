package com.devices.device;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Device {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "battery_power")
    private Integer batteryPower;

    @Column(name = "clock_speed")
    private Float clockSpeed;

    private Boolean blue;

    @Column(name = "dual_sim")
    private Boolean dualSim;

    private Integer fc;

    @Column(name = "four_g")
    private Float fourG;

    @Column(name = "int_memory")
    private Float intMemory;

    @Column(name = "m_dep")
    private Float mDep;

    @Column(name = "mobile_wt")
    private Float mobileWt;

    @Column(name = "n_cores")
    private Float nCores;

    private Integer pc;

    @Column(name = "px_height")
    private Float pxHeight;

    @Column(name = "px_width")
    private Float pxWidth;

    private Float ram;

    @Column(name = "sc_h")
    private Float scH;

    @Column(name = "sc_w")
    private Float scW;

    @Column(name = "talk_time")
    private Integer talkTime;

    @Column(name = "three_g")
    private Boolean threeG;

    @Column(name = "touch_screen")
    private Boolean touchScreen;

    private Boolean wifi;

    @Column(name = "price_range", nullable = true)
    private Integer priceRange;

    // Constructors, getters, and setters

    public Device() {
    }

    public Device(Integer batteryPower, Boolean blue, Float clockSpeed, Boolean dualSim, Integer fc, Float fourG,
                  Float intMemory, Float mDep, Float mobileWt, Float nCores, Integer pc, Float pxHeight, Float pxWidth,
                  Float ram, Float scH, Float scW, Integer talkTime, Boolean threeG, Boolean touchScreen,
                  Boolean wifi, Integer priceRange) {
        this.batteryPower = batteryPower;
        this.blue = blue;
        this.clockSpeed = clockSpeed;
        this.dualSim = dualSim;
        this.fc = fc;
        this.fourG = fourG;
        this.intMemory = intMemory;
        this.mDep = mDep;
        this.mobileWt = mobileWt;
        this.nCores = nCores;
        this.pc = pc;
        this.pxHeight = pxHeight;
        this.pxWidth = pxWidth;
        this.ram = ram;
        this.scH = scH;
        this.scW = scW;
        this.talkTime = talkTime;
        this.threeG = threeG;
        this.touchScreen = touchScreen;
        this.wifi = wifi;
        this.priceRange = priceRange;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(Integer batteryPower) {
        this.batteryPower = batteryPower;
    }

    public Boolean getBlue() {
        return blue;
    }

    public void setBlue(Boolean blue) {
        this.blue = blue;
    }

    public Float getClockSpeed() {
        return clockSpeed;
    }

    public Integer getPc() {
        return pc;
    }

    public void setPc(Integer pc) {
        this.pc = pc;
    }

    public void setClockSpeed(Float clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public Boolean getDualSim() {
        return dualSim;
    }

    public void setDualSim(Boolean dualSim) {
        this.dualSim = dualSim;
    }

    public Integer getFc() {
        return fc;
    }

    public void setFc(Integer fc) {
        this.fc = fc;
    }

    public Float getFourG() {
        return fourG;
    }

    public void setFourG(Float fourG) {
        this.fourG = fourG;
    }

    public Float getIntMemory() {
        return intMemory;
    }

    public void setIntMemory(Float intMemory) {
        this.intMemory = intMemory;
    }

    public Float getMDep() {
        return mDep;
    }

    public void setMDep(Float mDep) {
        this.mDep = mDep;
    }

    public Float getMobileWt() {
        return mobileWt;
    }

    public void setMobileWt(Float mobileWt) {
        this.mobileWt = mobileWt;
    }

    public Float getNCores() {
        return nCores;
    }

    public void setNCores(Float nCores) {
        this.nCores = nCores;
    }

    public Float getPxHeight() {
        return pxHeight;
    }

    public void setPxHeight(Float pxHeight) {
        this.pxHeight = pxHeight;
    }

    public Float getPxWidth() {
        return pxWidth;
    }

    public void setPxWidth(Float pxWidth) {
        this.pxWidth = pxWidth;
    }

    public Float getRam() {
        return ram;
    }

    public void setRam(Float ram) {
        this.ram = ram;
    }

    public Float getScH() {
        return scH;
    }

    public void setScH(Float scH) {
        this.scH = scH;
    }

    public Float getScW() {
        return scW;
    }

    public void setScW(Float scW) {
        this.scW = scW;
    }

    public Integer getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(Integer talkTime) {
        this.talkTime = talkTime;
    }

    public Boolean getThreeG() {
        return threeG;
    }

    public void setThreeG(Boolean threeG) {
        this.threeG = threeG;
    }

    public Boolean getTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(Boolean touchScreen) {
        this.touchScreen = touchScreen;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Integer getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Integer priceRange) {
        this.priceRange = priceRange;
    }
}
