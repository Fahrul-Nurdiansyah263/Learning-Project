document.addEventListener('DOMContentLoaded', () =>{
    const display = document.querySelector('.calculator-display');
    const buttonsContainer = document.querySelector('.calculator-buttons');

    let displayValue = '0'
    let firstOperand = null;
    let operator = null;
    let waitingForSecondOperand = false;

    function updateDisplay() {
        display.value = displayValue;
    }
    updateDisplay();

    buttonsContainer.addEventListener('click', (event) => {
        const target = event.target;

        if(!target.matches('button')){
            return;
        }

        const value = target.dataset.value;

        switch(value){
            case '+':
            case '-':
            case '/':
            case '*':
            case '=':
                handleOperator(value);
                break;
            case '.':
                inputDecimal(value);
                break;
            case 'clear':
                resetCalculator();
                break;
            default:
                inputDigit(value);
        }
        updateDisplay();
    });
    function inputDigit(digit){
        if (waitingForSecondOperand === true) {
            displayValue = digit;
            waitingForSecondOperand = false;
        } else {
            displayValue = displayValue === '0' ? digit : displayValue + digit;
        }
    }

    function inputDecimal(dot){
        if(!displayValue.includes(dot)){
            displayValue += dot;
        }
    }

    function handleOperator(nextOperator) {
        const inputValue = parseFloat(displayValue);

        if (operator && waitingForSecondOperand){
            operator = nextOperator;
            return;
        }

        if (firstOperand === null && !isNaN(inputValue)){
            firstOperand = inputValue;
        } else if (operator) {
            const result = performCalculation();
            displayValue = String(result);
            firstOperand = result;
        }
        waitingForSecondOperand = true;

        if (nextOperator !== '='){
            operator = nextOperator;
        } else {
            operator = null;
        }
    }

    function performCalculation() {
        if (operator === null || waitingForSecondOperand) return;

        const secondOperand = parseFloat(displayValue);

        if (operator === '+') {
            return firstOperand + secondOperand;
        } else if (operator === '-') {
            return firstOperand - secondOperand;
        } else if (operator === '*') {
            return firstOperand * secondOperand;
        } else if (operator === '/') {
            if (secondOperand === 0) {
                alert("Error: Tidak bisa membagi dengan nol");
                return 0;
            }
            return firstOperand / secondOperand;
        }
        return secondOperand;
    }

    function resetCalculator() {
        displayValue = '0';
        firstOperand = null;
        operator = null;
        waitingForSecondOperand = false;
    }
});