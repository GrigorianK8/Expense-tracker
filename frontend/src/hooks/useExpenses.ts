import { useEffect, useState } from 'react'
import { Expense } from '../model/Expense'
import { getExpenses } from '../services/Expense-service'

const useExpenses = () => {
  const [expenses, setExpenses] = useState<Expense[]>([])
  const [error, setErrors] = useState(null)
  const [isLoading, setLoader] = useState(false)

  useEffect(() => {
    setLoader(true)
    getExpenses()
    .then((response) => {
      setExpenses(response.data)
      setLoader(false)
    })
    .catch((error) => setErrors(error.message))
    .finally(() => setLoader(false))
  }, [])

  return {expenses, error, isLoading}
}

export default useExpenses;