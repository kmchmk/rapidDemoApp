package eu.project.rapid.AlgoTest;

import android.util.Log;

import java.lang.reflect.Method;

import eu.project.rapid.ac.DFE;
import eu.project.rapid.ac.Remote;
import eu.project.rapid.ac.Remoteable;
import eu.project.rapid.ac.utils.Utils;

/**
 * Created by android on 8/9/2017.
 */

public class AlgoTest extends Remoteable  {


        private static final long serialVersionUID = 5687713591581731140L;
        private static final String TAG = "NQueens";
        private int N = 8;
        private int nrClones;
        private transient DFE dfe;
        private  String brdresult = "";

        /**
         * @param dfe The execution dfe taking care of the execution
         * @param nrClones In case of remote execution specify the number of clones needed
         */
        public AlgoTest(DFE dfe, int nrClones) {
            this.dfe = dfe;
            this.nrClones = nrClones;
            //res= new StringBuilder();
            // this.brd=new Intent(context,board.class);


        }

        /**
         * @param dfe The execution dfe taking care of the execution
         */
        public AlgoTest(DFE dfe) {
            this(dfe, 1);
        }

        @Override
        public void prepareDataOnClient() {

        }

        /**
         * Solve the N-queens problem
         *
         * @param N The number of queens
         * @return The number of solutions found
         */
        public int solveAlgoTest(int N) {
            this.N = N;
            Method toExecute;
            Class<?>[] paramTypes = {int.class};
            Object[] paramValues = {N};

            int result = 0;
            try {
                toExecute = this.getClass().getDeclaredMethod("localSolveAlgoTest", paramTypes);
                result = (Integer) dfe.execute(toExecute, paramValues, this);
            } catch (SecurityException e) {
                // Should never get here
                e.printStackTrace();
                throw e;
            } catch (NoSuchMethodException e) {
                // Should never get here
                e.printStackTrace();
            } catch (Throwable e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return result;
        }

        @Remote
        public long localSolveAlgoTest(int N) {
                long result = 1;
                for (int i = 2; i <= N; i++) {
                    result *= i;
                }
                return result;
        }


        public int localSolveAlgoTestReduce(int[] params) {
            int solutions = 0;
            for (int i = 0; i < params.length; i++) {
                Log.i(TAG, "Adding " + params[i] + " partial solutions.");
                solutions += params[i];
            }
            return solutions;
        }


        @Override
        public void copyState(Remoteable state) {

        }




}
