package com.library.Model;

public abstract class  Member {
    private int memberID;
    private String name;

    public Member(int memberID, String name) {
        this.memberID = memberID;
        this.name = name;
    }

    public int getMemberID() {
        return this.memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int getMaxBorrowingDays();

    @Override
    public String toString() {
        return "Member ID: " + memberID +
               "\nName: " + name;
    }
}
