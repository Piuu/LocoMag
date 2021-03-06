/**
 * Created by Thisun Pathirage on 12/4/2017.
 */
var db = require('../database/mysqlConnection');

var Failure = {
    getAllFailures: function (callback) {
        return db.query("select * from failure_occured", callback);
    },
    getFailureById: function (id, callback) {
        if(id=="id"){
            return db.query("select loco_ID from failure_occured", callback);
        }else{
            return db.query("select * from failure_occured where loco_ID=?", [id], callback);
        }

    },
    addFailure: function (failure, callback) {
        console.log(failure);
        return db.query("insert into failure_occured(loco_ID,failure_ID,trip_ID,place,nearest_yard,occured_time,date,emp_ID,failure_description,recovery_option,current_state_of_loco) values(?,?,?,?,?,?,?,?,?,?,?)", [failure.locoID, failure.failureId, failure.tripId, failure.place, failure.nearestYard, failure.date,failure.time, failure.employeeId, failure.failureDescription,failure.counteraction,failure.currentState], function (err, count) {
            if (err) {
                callback(err, null);
            } else {
                db.query("SHOW TABLE STATUS LIKE 'locomotive'", callback);
            }
        })
    },
    deleteFailure: function (id, callback) {
        return db.query("delete from failure_occured where ID=?", [id], callback);
    },
}

module.exports=Failure;
