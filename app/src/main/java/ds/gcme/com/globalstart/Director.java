package ds.gcme.com.globalstart;

import android.content.Context;
import android.content.Intent;

import ds.gcme.com.globalstart.Do.Do_Find_Others;
import ds.gcme.com.globalstart.Do.Do_Prayer;
import ds.gcme.com.globalstart.Do.Do_Take_Action;
import ds.gcme.com.globalstart.Goal.Goal_Build;
import ds.gcme.com.globalstart.Goal.Goal_Know_Goal;
import ds.gcme.com.globalstart.Goal.Goal_Movement;
import ds.gcme.com.globalstart.Goal.Goal_Send;
import ds.gcme.com.globalstart.Goal.Goal_Sowing_Evangelism;
import ds.gcme.com.globalstart.Goal.Goal_Win;
import ds.gcme.com.globalstart.GodHeart.GodHeart_Examples;
import ds.gcme.com.globalstart.GodHeart.GodHeart_Take_Action;
import ds.gcme.com.globalstart.GodHeart.GodHeart_Teenager;
import ds.gcme.com.globalstart.Learn.Learn_How_To_Learn;
import ds.gcme.com.globalstart.Learn.Learn_Jesus_Model;
import ds.gcme.com.globalstart.Learn.Learn_Take_Action;
import ds.gcme.com.globalstart.Learn.Learn_Understand_Youth;


/**
 * Created by Roger on 6/17/2016.
 */
public class Director {

    public static Intent getGodHeart(Context cxt, int position){
        switch (position){
            case 0:
                return new Intent(cxt, GodHeart_Teenager.class);
            case 1:
                return new Intent(cxt, GodHeart_Examples.class);
            case 2:
                return new Intent(cxt, GodHeart_Take_Action.class);
        }
        return null;
    }

    public static Intent getLearn(Context cxt, int position){
        switch (position){
            case 0:
                return new Intent(cxt, Learn_Understand_Youth.class);
            case 1:
                return new Intent(cxt, Learn_Jesus_Model.class);
            case 2:
                return new Intent(cxt, Learn_How_To_Learn.class);
            case 3:
                return new Intent(cxt, Learn_Take_Action.class);
        }
        return null;
    }

    public static Intent getDo(Context cxt, int position){
        switch (position){
            case 0:
                return new Intent(cxt, Do_Prayer.class);
            case 1:
                return new Intent(cxt, Do_Find_Others.class);
            case 2:
                return new Intent(cxt, Do_Take_Action.class);
        }
        return null;
    }


    public static Intent getGoal(Context cxt, int position){
        switch (position){
            case 0:
                return new Intent(cxt, Goal_Know_Goal.class);
            case 1:
                return new Intent(cxt, Goal_Win.class);
            case 2:
                return new Intent(cxt, Goal_Sowing_Evangelism.class);
            case 3:
                return new Intent(cxt, Goal_Build.class);
            case 4:
                return new Intent(cxt, Goal_Send.class);
            case 5:
                return new Intent(cxt, Goal_Movement.class);
        }
        return null;
    }
}
