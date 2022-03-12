package controller;

public class MetricCalculation {
	private Double minimum = 0.0;
	private Double maximum = 0.0;
	private Double average = 0.0;
	private Integer nbr_metrics = 0;
	private Double sum_values = 0.0;
	
	public MetricCalculation(Double minimum) {
		this.minimum = minimum;
	}
	
	public void calculation(Double metric) {
		if (metric < minimum) {
			setMinimum(metric);
		}
		
		if (metric > maximum) {
			setMaximum(metric);
		}
		
		sum_values += metric;
		nbr_metrics++;
		setAverage(sum_values / nbr_metrics);
	}

	public Double getMinimum() {
		return minimum;
	}

	public void setMinimum(Double minimum) {
		this.minimum = minimum;
	}

	public Double getMaximum() {
		return maximum;
	}

	public void setMaximum(Double maximum) {
		this.maximum = maximum;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}
}
