package com.example.a7minworkout

class Exercises {
    companion object ExercisesObj {
        public fun getExercise(): ArrayList<exerciseList> {
            var workoutlist = ArrayList<exerciseList>()
            var jumpingjack = exerciseList(
                1,
                "jumping jack",
                R.drawable.jumpingjack,
                false
            )
            workoutlist.add(jumpingjack)

            var squats = exerciseList(
                1,
                "squats ",
                R.drawable.squats,
                false
            )
            workoutlist.add(squats)

            var plank = exerciseList(
                1,
                " plank",
                R.drawable.plank,
                false
            )
            workoutlist.add(plank)

            return workoutlist

        }
    }
    }