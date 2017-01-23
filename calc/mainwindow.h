#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

private slots:
    void digitClicked();
    void unaryOperatorClicked();
    void binaryOperatorClicked();
    void equalClicked();
    void pointClicked();
    void clear();

private:
    Ui::MainWindow *ui;
    bool waitingForOperand;
    double sumInMemory;
    QString pendingOperator;
};

#endif // MAINWINDOW_H
