import { useState } from 'react'
import styled from "styled-components"
import GameCavas from "./components/GameCanvas";
import InitUILayer from './components/InitUILayer';
import {
  useQuery,
  useMutation,
  useQueryClient,
  QueryClient,
  QueryClientProvider,
} from '@tanstack/react-query'

const queryClient = new QueryClient()

function App() {
  return (
    <QueryClientProvider client={queryClient}>
      <AppContainer>
        <GameCavas />
        <InitUILayer />
      </AppContainer>
    </QueryClientProvider>
  )
}

const AppContainer = styled.div`
  flex-grow: 1;
`

export default App
