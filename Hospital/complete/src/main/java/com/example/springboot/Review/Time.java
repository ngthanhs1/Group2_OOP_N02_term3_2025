package com.example.springboot.Review;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }
	public void nextSecond() {
		if (hour == 23 && minute == 59 && second == 59) {
			hour = 0;
			minute = 0;
			second = 0;
			return;
		}
		if (minute == 59 && second == 59) {
			hour++;
			minute = 0;
			second = 0;
			return;
		}
		if (second == 59) {
			minute++;
			second = 0;
			return;
		}
		second++;
	}

    public void display() {
        String hour = this.hour + "";
		String minute = this.minute + "";
		String second = this.second + "";
		if (hour.length() == 1)
			hour = "0" + hour;
		if (minute.length() == 1)
			minute = "0" + minute;
		if (second.length() == 1)
			second = "0" + second;
		System.out.println(hour + ":" + minute + ":" + second);
    }
}
