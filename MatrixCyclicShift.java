class MatrixCyclicShift {
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 1, 2},
            {5, 5, 5, 5},
            {6, 3, 6, 3}
        };

        int[][] mat2 = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        int[][] mat3 = {
            {1,2}
        };

        int[][] mat4 = {
            {7,7},
            {10,10},
            {4,4}
        };

        MatrixCyclicShift mcs = new MatrixCyclicShift();
        // boolean result = mcs.areSimilar(mat, 2);
        boolean result2 = mcs.areSimilar(mat2, 4);
        boolean result3 = mcs.areSimilar(mat3, 1);
        boolean result4 = mcs.areSimilar(mat4, 2);
        System.out.println("\n" + result4); // Expected output: true
    }

    public boolean areSimilar(int[][] mat, int k) {
        int[][] newMat = new int[mat.length][mat[0].length];
        boolean isSimilar = true;

        for (int i = 0; i < mat.length; i++){
            int[] row = mat[i];
            int rowLength = row.length;
            int positionShift = k - (k % rowLength);
            if (rowLength%2 == 0 && rowLength <= 2){
                positionShift -= 1;
            }
            int[] shiftedRow = new int[rowLength];

            if (i%2 == 0){
                for(int j = 0; j < rowLength; j++){
                    int positionShiftLeft = ((positionShift - j) % rowLength);
                    if (rowLength > 2 && rowLength%2 == 0){
                        positionShiftLeft = ((positionShift - j - k) % rowLength);
                    }
                    if (rowLength == 2 && k%2 == 0){
                        positionShiftLeft = (positionShift - j);
                    }
                    if (positionShiftLeft < 0) {
                        positionShiftLeft *= -1;
                    }
                    System.out.println("PositionShiftLeft: " + positionShiftLeft);
                    shiftedRow[j] = row[positionShiftLeft];
                    System.out.println(shiftedRow[j]);
                }

                newMat[i] = shiftedRow;
            }else{
                for(int j = 0; j < rowLength; j++){
                    int positionShiftRight = (positionShift + k + j) % rowLength;
                    if (mat.length <= 2){
                        positionShiftRight = ((positionShift + j) % rowLength);
                    }
                    if (rowLength == 2 && k%2 == 0){
                        positionShiftRight = (positionShift - j);
                    }
                    System.out.println("PositionShift: " + positionShiftRight);
                    shiftedRow[j] = row[positionShiftRight];
                    System.out.println(shiftedRow[j]);
                }
                newMat[i] = shiftedRow;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j< mat[i].length; j++){
                if(newMat[i][j] != mat[i][j]){
                    isSimilar = false;
                    break;
                }
            }
        }
        return isSimilar;
    }
}