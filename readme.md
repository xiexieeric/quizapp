#Android MiniApp - QuizApp
<h2>Usage Instructions</h2>
At launch, user will see a list of unfinished quizzes under the �To Do� tab. Initially, there are two quizzes, MyersBriggsQuiz and UVAQuiz, both of which are multiple choice quizzes with two answer options. Swiping left or tapping on the �Done� tab will allow the user to list of finished quizzes, which will be empty initially. Tapping on a quiz in the �To Do� tab will launch the quiz activity. Tapping on an answer choice advances to the next question. A progress bar indicates current progress in the quiz. Upon completion of all the questions the quiz will automatically generate the results. Tapping on the �Return to Quiz List� button will return the user to the �To Do� tab and the finished quiz should no longer show in this tab, but will be show in the �Done� tab. To review the results for a quiz, navigate to the �Done� tab and select a quiz. A toast will show with the quiz results.
<h2>Lessons Learned</h2>
With no prior experience we resorted to online tutorials and example code frequently to set up our Android project. It was confusing to see UI elements being added through an xml file rather than through java code, especially since so much functionality could be achieved in just a few lines of XML. These included adding a view to the activity, setting onClickListeners and changing relative positioning of elements. But XML was not straightforward, even with the visual editor. Usually getting an element placed exactly the way we want it required countless trial and error through both the visual editor and the text editor. Another point of confusion was the use of adapters. It seems like many tutorials suggested the use of one, while it was completely acceptable to create activities without the use of one such as in our actual quiz activity, although we did use adapters in our �To Do� and �Done� fragments.
Our understanding is that adapters are useful in more advanced apps that require dynamically generated