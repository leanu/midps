#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QtWidgets>

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    waitingForOperand = true;
}

void MainWindow::digitClicked(){
    QPushButton *clickedButton = qobject_cast<QPushButton *>(sender());
    int digitValue = clickedButton->text().toInt();
    if(ui->summator->toPlainText() == "0" && digitValue==0.0)
        return;
    if (waitingForOperand) {
        ui->summator->clear();
        waitingForOperand = false;
    }
    ui->summator->setText(ui->summator->toPlainText() + QString::number(digitValue));
}

void MainWindow::unaryOperatorClicked(){
    QPushButton *clickedButton = qobject_cast<QPushButton *>(sender());
    QString clickedOperator = clickedButton->text();
    double operand = ui->summator->toPlainText().toDouble();
    double result = 0.0;

    if (clickedOperator == tr("sqrt")) {
        result = sqrt(operand);
    }
    else if (clickedOperator == tr("x^2")){
        result = pow(operand, 2.0);
    }
    else if (clickedOperator == tr("+/-")){
        result = -operand;
    }
    ui->summator->setText(QString::number(result));
    waitingForOperand = true;
}

void MainWindow::binaryOperatorClicked(){
    QPushButton *clickedButton = qobject_cast<QPushButton *>(sender());
    QString clickedOperator = clickedButton->text();
    double operand = ui->summator->toPlainText().toDouble();
    ui->summator->setText("0");
    sumInMemory=operand;
    pendingOperator=clickedOperator;
    waitingForOperand = true;
}

void MainWindow::equalClicked(){
    double operand = ui->summator->toPlainText().toDouble();
    double result = 0.0;
    if (pendingOperator=="/") result = sumInMemory/operand;
    else if (pendingOperator=="-") result = sumInMemory-operand;
    else if (pendingOperator=="+") result = sumInMemory+operand;
    else if (pendingOperator=="x") result = sumInMemory*operand;

    ui->summator->setText(QString::number(result));
    sumInMemory=0.0;
    waitingForOperand = true;
}

void MainWindow::pointClicked(){
    if (waitingForOperand)
        ui->summator->setText("0");
    if (!ui->summator->toPlainText().contains("."))
        ui->summator->setText(ui->summator->toPlainText() + tr("."));
    waitingForOperand = false;
}

void MainWindow::clear(){
    ui->summator->setText("0");
    waitingForOperand = true;
}

MainWindow::~MainWindow()
{
    delete ui;
}
