//: com.thinkjava.ch21.concurrency.toast/Toast.java

package com.thinkjava.ch21.concurrency.toast;

/**
 * A toaster uses BlockingQueue
 * Toast enum Status { DRY, BUTTERED, JAMMED }
 * Init status with DRY, method butter() Status.BUTTERED, jam() Status.JAMMED
 * @author kevin.zhou <kevin.zhou@hotmail.co.uk>
 * @date 2016-09-07 
 */ 

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Toast {
    /**
     * enum Status three status { DRY, BUTTERED, JAMMED }
     */
    public enum Status { DRY, BUTTERED, JAMMED }

    /**
     * init status is DRY
     */
    private Status status = Status.DRY;

    /**
     * contains a final int id to mark the Toast object
     */
    private final int id;

    /** 
     * constrct with number id
     */
    public Toast( int id ) {
        this.id = id;
    }

    /**
     * method butter() set status to Status.BUTTERED
     */
    public void butter() {
        this.status = Status.BUTTERED;
    }

    /**
     * method jam() set status to Status.JAMMED
     */
    public void jam() {
        this.status = Status.JAMMED;
    }

    /**
     * method getStatus() return current status
     * @return Status
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * method getId() return toast id
     * @return int id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Override method toString() return toast object toString
     * @return Toast id + status
     */
    @Override
    public String toString() {
        return "Toast " + id + ": " + status;
    }
}