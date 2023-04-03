import { useState } from 'react'
import styled from 'styled-components'

function GameCanvas() {
  const [count, setCount] = useState(0)

  return (
    <Container>
      
    </Container>
  )
}

const Container = styled.div`
  width: 100%;
  height: 100vh;
  background-color: grey;
`

export default GameCanvas
