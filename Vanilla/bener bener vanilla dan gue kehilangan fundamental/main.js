const transactions = [
  { type: "income", amount: 5000000 },
  { type: "expense", amount: 1500000 },
  { type: "income", amount: 3000000 },
  { type: "expense", amount: 500000 },
  { type: "income", amount: 2000000 }
]

//output
// {
//   totalIncome: 1.000.0000,
//   totalExpense: 2.000.000,
//   balance: 8000000
// }

function getTransactionSummary(transactions) {
  const result = transactions.reduce((acc, total) => {
    if(total.type === "income"){
       acc.totalIncome += total.amount
       return acc
    }if (total.type === "expense") {
      acc.totalExpense += total.amount
      return acc
    }
    acc.balance = acc.totalIncome - acc.totalExpense;
    return acc
  }, {
    totalIncome: 0,
    totalExpense: 0,
    balance: 0
  })
  

  return console.log(result)
}

getTransactionSummary(transactions)