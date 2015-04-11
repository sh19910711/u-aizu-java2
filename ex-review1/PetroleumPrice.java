public class PetroleumPrice {
  private Double gasolinePrice;
  private Double dieselPrice;

  public PetroleumPrice(Double gasolinePrice, Double dieselPrice) {
    this.gasolinePrice = gasolinePrice;
    this.dieselPrice = dieselPrice;
  }

  public Double getGasolineCost() {
    return this.gasolinePrice;
  }

  public Double getDieselCost() {
    return this.dieselPrice;
  }
}
