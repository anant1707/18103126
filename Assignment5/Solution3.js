var bracketMatching = function (str) 
{

    var stack = [];
    var map = 
    {
        '(': ')',
        '[': ']',
        '{': '}'
    }

    for (let i = 0; i < str.length; i++) 
    {
        if (str[i] === '(' || str[i] === '{' || str[i] === '[' ) 
        {
            stack.push(str[i]);
        }
        else 
        {
            let last = stack.pop();
            if (str[i] !== map[last]) 
            {
                return false;
            }
        }
    }
    if (stack.length !== 0) 
    {
        return false;
    }
    return true;
}


var inputString = prompt("Enter any string containing {,(,[,],)or }:");

console.log(bracketMatching(inputString));
