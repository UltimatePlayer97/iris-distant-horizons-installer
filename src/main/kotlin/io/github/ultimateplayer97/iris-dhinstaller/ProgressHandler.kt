package io.github.ultimateplayer97.`iris-dhinstaller`

interface ProgressHandler {
    fun prepareNewTaskSet(prepareMessage: String)

    fun newTaskSet(numTasks: Int)

    fun newTask(title: String)

    fun done()
}