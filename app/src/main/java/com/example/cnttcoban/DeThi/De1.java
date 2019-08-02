package com.example.cnttcoban.DeThi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.cnttcoban.Controller.Question;
import com.example.cnttcoban.Controller.TaoCauHoi;
import java.util.ArrayList;
import java.util.Map;
import java.util.TimerTask;

public class De1 {
    private int waitQuestion = 2000;
    private int switchNewQuestion = 3000;
    private ArrayList<Question> de1;
    @SuppressLint("StaticFieldLeak")
    private static Button a;
    @SuppressLint("StaticFieldLeak")
    private static Button b;
    @SuppressLint("StaticFieldLeak")
    private static Button c;
    @SuppressLint("StaticFieldLeak")
    private static Button d;
    private TextView tvQuesContainer;
    private Question question;
    private int index;
    private int questionAmount = 0;

    private int getQuestionAmount() {
        return questionAmount;
    }

    public void setQuestionAmount() {
        this.questionAmount = 50;
    }

    public De1(final Activity activity, Button a, Button b, Button c, Button d, TextView tvQuesContainer) {
        De1.a = a;
        De1.b = b;
        De1.c = c;
        De1.d = d;
        this.tvQuesContainer = tvQuesContainer;
        de1 = TaoCauHoi.createQuestions1(activity);
    }


    private void btnGreenRight(final String correctAnswer) {
        final Button btnCorrectAnswer;

        if (a.getTag().equals(correctAnswer)) {
            btnCorrectAnswer = a;
        } else if (b.getTag().equals(correctAnswer)) {
            btnCorrectAnswer = b;
        } else if (c.getTag().equals(correctAnswer)) {
            btnCorrectAnswer = c;
        } else {
            btnCorrectAnswer = d;
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btnCorrectAnswer.setTextColor(Color.GREEN);
            }
        }, waitQuestion);

    }

    public void playGame() {
        new TimerTask() {
            @Override
            public void run() {
            }
        };
        int myFirstQuestion = 0;
        askQuestion(myFirstQuestion, new De1.reply() {
            @Override
            public void answer() {
            }

            @Override
            public void falseAnswer() {

            }
        });
    }

    public interface reply {
        void answer();

        void falseAnswer();
    }

    @SuppressLint("SetTextI18n")
    private void askQuestion(int questionOrder, final De1.reply reply) {
        index = questionOrder;
        question = de1.get(index);
        Map<String, String> answer;
        answer = question.getAnswer();
        a.setText(answer.get("1"));
        b.setText(answer.get("2"));
        c.setText(answer.get("3"));
        d.setText(answer.get("4"));
        a.setEnabled(true);
        b.setEnabled(true);
        c.setEnabled(true);
        d.setEnabled(true);
        a.setTextColor(Color.BLACK);
        b.setTextColor(Color.BLACK);
        c.setTextColor(Color.BLACK);
        d.setTextColor(Color.BLACK);
        tvQuesContainer.setText(question.getQuestion());
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGreenRight(question.getRightAnswer());
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (a.getTag().equals(question.getRightAnswer())) {
                            a.setTextColor(Color.GREEN);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    reply.answer();
                                    if (index < (getQuestionAmount() - 1)) {
                                        index++;
                                        askQuestion(index, new De1.reply() {
                                            @Override
                                            public void answer() {
                                            }

                                            @Override
                                            public void falseAnswer() {
                                            }
                                        });
                                    }
                                }
                            }, switchNewQuestion);
                        } else {
                            a.setTextColor(Color.RED);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    reply.falseAnswer();
                                    if (index < (getQuestionAmount() - 1)) {
                                        index++;
                                        askQuestion(index, new De1.reply() {
                                            @Override
                                            public void answer() {
                                            }

                                            @Override
                                            public void falseAnswer() {
                                            }
                                        });
                                    }
                                }
                            }, switchNewQuestion);

                        }
                    }
                }, waitQuestion);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGreenRight(question.getRightAnswer());
                b.setEnabled(false);
                a.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (b.getTag().equals(question.getRightAnswer())) {
                            b.setTextColor(Color.GREEN);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    reply.answer();
                                    if (index < (getQuestionAmount() - 1)) {
                                        index++;
                                        askQuestion(index, new De1.reply() {
                                            @Override
                                            public void answer() {

                                            }

                                            @Override
                                            public void falseAnswer() {
                                            }
                                        });
                                    }
                                }
                            }, switchNewQuestion);
                        } else {
                            b.setTextColor(Color.RED);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    reply.falseAnswer();
                                    if (index < (getQuestionAmount() - 1)) {
                                        index++;
                                        askQuestion(index, new De1.reply() {
                                            @Override
                                            public void answer() {
                                            }

                                            @Override
                                            public void falseAnswer() {
                                            }
                                        });
                                    }
                                }
                            }, switchNewQuestion);

                        }
                    }
                }, waitQuestion);
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGreenRight(question.getRightAnswer());
                c.setEnabled(false);
                b.setEnabled(false);
                a.setEnabled(false);
                d.setEnabled(false);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (c.getTag().equals(question.getRightAnswer())) {
                            c.setTextColor(Color.GREEN);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    reply.answer();
                                    if (index < (getQuestionAmount() - 1)) {
                                        index++;
                                        askQuestion(index, new De1.reply() {
                                            @Override
                                            public void answer() {
                                            }

                                            @Override
                                            public void falseAnswer() {
                                            }
                                        });
                                    }
                                }
                            }, switchNewQuestion);
                        } else {
                            c.setTextColor(Color.RED);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    reply.falseAnswer();
                                    if (index < (getQuestionAmount() - 1)) {
                                        index++;
                                        askQuestion(index, new De1.reply() {
                                            @Override
                                            public void answer() {
                                            }

                                            @Override
                                            public void falseAnswer() {
                                            }
                                        });
                                    }
                                }
                            }, switchNewQuestion);
                        }
                    }
                }, waitQuestion);
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGreenRight(question.getRightAnswer());
                d.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                a.setEnabled(false);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (d.getTag().equals(question.getRightAnswer())) {
                            d.setTextColor(Color.GREEN);
                            final Handler handler = new Handler();
                            reply.answer();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    if (index < (getQuestionAmount() - 1)) {
                                        index++;
                                        askQuestion(index, new De1.reply() {
                                            @Override
                                            public void answer() {
                                            }

                                            @Override
                                            public void falseAnswer() {
                                            }
                                        });
                                    }
                                }
                            }, switchNewQuestion);
                        } else {
                            d.setTextColor(Color.RED);
                            final Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    reply.falseAnswer();
                                    if (index < (getQuestionAmount() - 1)) {
                                        index++;
                                        askQuestion(index, new De1.reply() {
                                            @Override
                                            public void answer() {
                                            }

                                            @Override
                                            public void falseAnswer() {
                                            }
                                        });
                                    }
                                }
                            }, switchNewQuestion);

                        }
                    }
                }, waitQuestion);
            }
        });
    }
}

