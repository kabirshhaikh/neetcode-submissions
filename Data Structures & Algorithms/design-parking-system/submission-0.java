class ParkingSystem {
    private int spaceForBig;
    private int spaceForMedium;
    private int spaceForSmall;

    public ParkingSystem(int big, int medium, int small) {
        this.spaceForBig = big;
        this.spaceForMedium = medium;
        this.spaceForSmall = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1 && spaceForBig == 0) {
            return false;
        }
        else if (carType == 2 && spaceForMedium == 0) {
            return false;
        }
        else if (carType == 3 && spaceForSmall == 0) {
            return false;
        }
        else if (carType == 1 && spaceForBig > 0) {
            spaceForBig--;
            return true;
        }
        else if (carType == 2 && spaceForMedium > 0) {
            spaceForMedium--;
            return true;
        }
        else if (carType == 3 && spaceForSmall > 0) {
            spaceForSmall--;
            return true;
        }

        return false;
    }
}

// 1 -> big
// 2 -> medium
// 3 -> small

// int big => 0 space available
// int medium => 1 space available
// int small => 1 space available

