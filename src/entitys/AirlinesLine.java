package entitys;

import java.time.LocalDateTime;

public class AirlinesLine {

	private String currentLocation;
	private String destination;
	private LocalDateTime time;
	
	public AirlinesLine(String currentLocation, String destination, LocalDateTime time) {
		this.currentLocation = currentLocation;
		this.destination = destination;
		this.time = time;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	public String toString() {
		return getCurrentLocation() + " > " + getDestination() + ", " + getTime();
	}
	
}
