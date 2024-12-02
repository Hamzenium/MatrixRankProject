package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.MatrixRank;

class MatrixRankTest {

    @Test
    void testFullRankSquareMatrix() {
        double[][] matrix = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        int rank = MatrixRank.computeRank(matrix);
        assertEquals(3, rank, "The rank of a full-rank 3x3 identity matrix should be 3.");
    }

    @Test
    void testReducedRankSquareMatrix() {
        double[][] matrix = {
            {1, 2, 3},
            {2, 4, 6},
            {3, 6, 9}
        };
        int rank = MatrixRank.computeRank(matrix);
        assertEquals(1, rank, "The rank of a matrix with linearly dependent rows should be 1.");
    }

    @Test
    void testFullRowRankRectangularMatrix() {
        double[][] matrix = {
            {1, 2, 3, 4},
            {0, 1, 2, 3},
            {0, 0, 1, 2}
        };
        int rank = MatrixRank.computeRank(matrix);
        assertEquals(3, rank, "The rank of a full-row-rank 3x4 matrix should be 3.");
    }

    @Test
    void testAllZeroMatrix() {
        double[][] matrix = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };
        int rank = MatrixRank.computeRank(matrix);
        assertEquals(0, rank, "The rank of an all-zero matrix should be 0.");
    }

    @Test
    void testSingleRowMatrix() {
        double[][] matrix = {
            {1, 2, 3}
        };
        int rank = MatrixRank.computeRank(matrix);
        assertEquals(1, rank, "The rank of a single row matrix should be 1.");
    }

    @Test
    void testSingleColumnMatrix() {
        double[][] matrix = {
            {1},
            {2},
            {3}
        };
        int rank = MatrixRank.computeRank(matrix);
        assertEquals(1, rank, "The rank of a single column matrix should be 1.");
    }

    @Test
    void testJaggedMatrixThrowsException() {
        double[][] matrix = {
            {1, 2, 3},
            {4, 5},
            {6}
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MatrixRank.computeRank(matrix);
        });
        assertEquals("The input matrix cannot be jagged", exception.getMessage());
    }

    @Test
    void testNullMatrixThrowsException() {
        double[][] matrix = null;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MatrixRank.computeRank(matrix);
        });
        assertEquals("The input matrix cannot be null", exception.getMessage());
    }

    @Test
    void testEmptyMatrixThrowsException() {
        double[][] matrix = {};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MatrixRank.computeRank(matrix);
        });
        assertEquals("The input matrix cannot be empty", exception.getMessage());
    }

    @Test
    void testMatrixWithNullRowsThrowsException() {
        double[][] matrix = {
            {1, 2, 3},
            null,
            {4, 5, 6}
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MatrixRank.computeRank(matrix);
        });
        assertEquals("The input matrix cannot have null or empty rows", exception.getMessage());
    }
}
