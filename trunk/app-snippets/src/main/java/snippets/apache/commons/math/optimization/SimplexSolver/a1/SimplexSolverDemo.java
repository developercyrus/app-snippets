package snippets.apache.commons.math.optimization.SimplexSolver.a1;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.RealPointValuePair;
import org.apache.commons.math.optimization.linear.LinearConstraint;
import org.apache.commons.math.optimization.linear.LinearObjectiveFunction;
import org.apache.commons.math.optimization.linear.Relationship;
import org.apache.commons.math.optimization.linear.SimplexSolver;

public class SimplexSolverDemo {
    public static void main(String[] arsg) throws OptimizationException {
        /*
        MAX 20x + 10y + 15z + 0
        S.T.
        3x + 2y + 5z <= 55
        2x + 1y + 1z <= 26
        1x + 1y + 3z <= 30
        5x + 2y + 4z <= 57
        1x + 0y + 0z >= 0
        0x + 1y + 0z >= 0
        0x + 0y + 1z >= 0
        */
        
        // describe the optimization problem
        LinearObjectiveFunction f = new LinearObjectiveFunction(new double[] { 20, 10, 15 }, 0);
        Collection<LinearConstraint> constraints = new ArrayList<LinearConstraint>();
        constraints.add(new LinearConstraint(new double[] { 3, 2, 5 }, Relationship.LEQ, 55));
        constraints.add(new LinearConstraint(new double[] { 2, 1, 1 }, Relationship.LEQ, 26));
        constraints.add(new LinearConstraint(new double[] { 1, 1, 3 }, Relationship.LEQ, 30));
        constraints.add(new LinearConstraint(new double[] { 5, 2, 4 }, Relationship.LEQ, 57));
        constraints.add(new LinearConstraint(new double[] { 1, 0, 0}, Relationship.GEQ, 0));
        constraints.add(new LinearConstraint(new double[] { 0, 1, 0 }, Relationship.GEQ, 0));
        constraints.add(new LinearConstraint(new double[] { 0, 0, 1 }, Relationship.GEQ, 0));

        // create and run the solver
        RealPointValuePair solution = new SimplexSolver().optimize(f, constraints, GoalType.MAXIMIZE, false);

        // get the solution
        double x = solution.getPoint()[0];
        double y = solution.getPoint()[1];
        double z = solution.getPoint()[2];
        double min = solution.getValue();
        
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        System.out.println("z=" + z);
        System.out.println("min=" + min);
    }
}
