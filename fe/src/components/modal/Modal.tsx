import styled from 'styled-components';
import { Button } from '../buttons/Button';

// type Mode = 'history' | 'card';

// interface ModalStyledProps {
//   mode: Mode;
// }

interface ModalProps {
  alertText: string;
}

export const ModalComponent: React.FC<ModalProps> = ({ alertText }) => {
  return (
    <>
      <StyledDim></StyledDim>
      <Modal>
        <p className="body">{alertText}</p>
        <div className="btns">
          <Button variant="contained" pattern="text-only" text="취소" />
          <Button variant="contained" pattern="text-only" text="삭제" />
        </div>
      </Modal>
    </>
  );
};

const StyledDim = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background: rgba(20, 33, 43, 0.3);
`;

export const Modal = styled.dialog`
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translateY(-50%) translateX(-50%);

  display: flex;
  width: 320px;
  padding: 24px;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 24px;

  border-radius: ${({ theme: { border } }) => border.radius8};
  box-shadow: ${({ theme: { shadows } }) => shadows.up.boxShadow};
  backdrop-filter: ${({ theme: { shadows } }) => shadows.up.backdropFilter};
  background-color: ${({ theme: { colors } }) => colors.surfaceDefault};

  .body {
    font: ${({ theme: { fonts } }) => fonts.displayM16};
    color: ${({ theme: { colors } }) => colors.textDefault};
  }
  .btns {
    display: flex;
    gap: 8px;
  }
`;
