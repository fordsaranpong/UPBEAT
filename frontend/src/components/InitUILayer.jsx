import { useState } from 'react'
import styled from 'styled-components'
import { useMutation } from '@tanstack/react-query'
import axios from "axios"
import { compact } from "lodash-es";

function InitUILayer() {
  const [count, setCount] = useState(0);
  const playMx = useMutation(async (players) => {
    const { data } = await axios.post("http://localhost:3000/init", players);
    return data;
  })

  const [viweNames, setViewNames] = useState([ true, true ])
  const [player1, setPlayer1] = useState("");
  const [player2, setPlayer2] = useState("");
  const [player3, setPlayer3] = useState("");
  const [player4, setPlayer4] = useState("");
  const [player5, setPlayer5] = useState("");
  
  function handleAdd() {
    setViewNames((prev) => [ ...prev, true ]);
  }

  function handleRemove() {
    if (viweNames.length <= 2) {
      return;
    }
    
    setViewNames((prev) => prev.slice(0, -1));
  }

  async function handleSubmit() {
    const players = compact([
      player1,
      player2,
      player3,
      player4,
      player5,
    ]);

    const data = await playMx.mutateAsync(players)
  }

  return (
    <Container>
      <Panel>
        <StyledForm>
          <h1>UPBEAT</h1>
          {viweNames[0] && <input type='text' onChange={(e) => setPlayer1(e.currentTarget.value)} value={player1} required={true} />}
          {viweNames[1] && <input type='text' onChange={(e) => setPlayer2(e.currentTarget.value)} value={player2} required={true} />}
          {viweNames[2] && <input type='text' onChange={(e) => setPlayer3(e.currentTarget.value)} value={player3} required={true} />}
          {viweNames[3] && <input type='text' onChange={(e) => setPlayer4(e.currentTarget.value)} value={player4} required={true} />}
          {viweNames[4] && <input type='text' onChange={(e) => setPlayer5(e.currentTarget.value)} value={player5} required={true} />}
          <button type='button' onClick={handleAdd}>Add</button>
          <button type='button' onClick={handleRemove}>Remove</button>
          <button type='button' onClick={handleSubmit}>Play</button>
        </StyledForm>
      </Panel>
    </Container>
  )
}

const Container = styled.div`
  top: 0;
  left: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  position: fixed;
  width: 100%;
  height: 100vh;
`

const Panel = styled.div`
  
`

const StyledForm = styled.form`
  display: flex;
  flex-direction: column;
  gap: 0.5em;
`

export default InitUILayer
