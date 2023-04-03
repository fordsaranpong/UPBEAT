import { useState } from 'react'
import styled from 'styled-components'

function UILayer() {
  const [count, setCount] = useState(0)

  return (
    <Container>
      <div></div>
    </Container>
  )
}

const Container = styled.div`
  
`

export default UILayer
