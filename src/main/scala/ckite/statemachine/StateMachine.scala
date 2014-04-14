package ckite.statemachine

import java.nio.ByteBuffer
import ckite.rpc.Command

trait StateMachine {

  def deserialize(byteBuffer: ByteBuffer)
  
  def serialize(): ByteBuffer
  
  def apply: PartialFunction[Command,Any]
  
}