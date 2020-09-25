package Challenge;

/**
 * Name: David
 * Data: 2020
 *
 * in this class i will answer questions
 * from Open University.
 * other problems:
 */
public class Range {
    /**
     *  data : 2017
     *  type : B
     *  Q: 2
     */

    class R
    {
        private int _center, _radius;
        public R (int c, int r)
        {
            _center = c;
            _radius = r;
        }

        public int get_center() {
            return _center;
        }

        public void set_center(int _center) {
            this._center = _center;
        }

        public int get_radius() {
            return _radius;
        }

        public void set_radius(int _radius) {
            this._radius = _radius;
        }
    }

    public static int findNum(R rangeA[], int num) {
        if (rangeA[0]._center - rangeA[0]._radius > num) {
            return -1;
        }
            for (int i = 0; i < rangeA.length; i++) {
                if (rangeA[i]._center + rangeA[i]._radius > num) {
                    return i;
                }
            }
        return -1;
    }


    public static void main(String[] args) {
        R[] range  = new R[4];
        range[0].set_center(4);
        range[0].set_radius(1);
        range[1].set_center(12);
        range[1].set_radius(0);
        range[2].set_center(20);
        range[2].set_radius(1);
        range[3].set_center(102);
        range[3].set_radius(2);

        try {


        }catch (Exception e){
            System.out.println("\n\nError");
        }finally {
            System.out.println("\n\nFinish\n");
        }

    }
}
