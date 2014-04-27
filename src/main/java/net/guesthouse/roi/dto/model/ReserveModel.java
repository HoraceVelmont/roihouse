package net.guesthouse.roi.dto.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;

public class ReserveModel {
	private int id;
	private String rType;
	private Timestamp reservDate;
	private String roomNo;
	private Timestamp chkin;
	private int night;
	private String rName;
	private int payPerDay;
	private int payment;
	private int deposit;
	private int balance;
	private String via;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getrType() {
		return rType;
	}

	public void setrType(String rType) {
		this.rType = rType;
	}

	@JsonDeserialize(using = DateDeserializer.class)
	public Timestamp getReservDate() {
		return reservDate;
	}

	public void setReservDate(Timestamp reservDate) {
		this.reservDate = reservDate;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	@JsonDeserialize(using = DateDeserializer.class)
	public Timestamp getChkin() {
		return chkin;
	}

	public void setChkin(Timestamp chkin) {
		this.chkin = chkin;
	}

	public int getNight() {
		return night;
	}

	public void setNight(int night) {
		this.night = night;
	}

	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public int getPayPerDay() {
		return payPerDay;
	}

	public void setPayPerDay(int payPerDay) {
		this.payPerDay = payPerDay;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

}
