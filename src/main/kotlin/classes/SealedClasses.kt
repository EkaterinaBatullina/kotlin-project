package classes

fun eval(expr: SealedExpr): Int =
    when (expr) {
        is SealedNum -> expr.value
        is SealedSum -> eval(expr.left) + eval(expr.right)
    }

sealed interface SealedExpr

class SealedNum(val value: Int) : SealedExpr

class SealedSum(val left: SealedExpr, val right: SealedExpr) : SealedExpr
